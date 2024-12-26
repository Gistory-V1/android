package view.post.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import model.auth.request.witecreaterequestModel
import usecase.book.createPostUseCase
import view.post.uistate.PostUistate
import javax.inject.Inject

@HiltViewModel
class writeviewmodel @Inject constructor(
    private val createPostUseCase: createPostUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    companion object {
        const val TITLE = "title"
        const val WRITE = "write"
    }

    internal var titleTextState = savedStateHandle.getStateFlow(key = TITLE, initialValue = "")

    internal var writeTextState = savedStateHandle.getStateFlow(key = WRITE, initialValue = "")

    private val _titleTextStateIsEmpty = MutableStateFlow(false)
    val titleTextStateIsEmpty: StateFlow<Boolean> = _titleTextStateIsEmpty.asStateFlow()

    private val _writeTextStateIsEmpty = MutableStateFlow(false)
    val writeTextStateIsEmpty: StateFlow<Boolean> = _writeTextStateIsEmpty.asStateFlow()

    private val _postUistate = MutableStateFlow<PostUistate>(PostUistate.Loading)
    val postUistate: StateFlow<PostUistate> = _postUistate.asStateFlow()


    internal fun checkButtonOnClick(
        titleTextState: String,
        writeTextState: String,
    ) = viewModelScope.launch {
        createPostUseCase(
            body = witecreaterequestModel(
                title = titleTextState,
                content = writeTextState
            )
        ).onSuccess {
            it.catch {
                _postUistate.value = PostUistate.Fail
            }.collect {
                _postUistate.value = PostUistate.Success
            }
        }
            .onFailure {
                _postUistate.value = PostUistate.Fail
            }
    }

    internal fun onTitleChanged(title: String) {
        savedStateHandle[TITLE] = title
        _titleTextStateIsEmpty.value = title.isEmpty()
    }

    internal fun onWriteChanged(write: String) {
        savedStateHandle[WRITE] = write
        _writeTextStateIsEmpty.value = write.isEmpty()
    }

    internal fun validateAndSetErrorStates(): Boolean {
        val isTitleEmpty = titleTextState.value.isEmpty()
        val isWriteEmpty = writeTextState.value.isEmpty()

        _titleTextStateIsEmpty.value = isTitleEmpty
        _writeTextStateIsEmpty.value = isWriteEmpty

        return !isTitleEmpty && !isWriteEmpty
    }

    internal fun resetTextState() {
        onTitleChanged("")
        onWriteChanged("")
    }
}

