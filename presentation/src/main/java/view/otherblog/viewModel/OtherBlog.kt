package view.otherblog.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.collections.immutable.toImmutableList
import usecase.book.getPostUseCase
import utill.asResult
import view.otherblog.UiState.OtherBlogUiState
import javax.inject.Inject

@HiltViewModel
class OtherBlog @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getPostsUseCase: getPostUseCase
) : ViewModel() {

    private val _postList = MutableStateFlow<OtherBlogUiState>(OtherBlogUiState.Loading)
    val postList: StateFlow<OtherBlogUiState> = _postList.asStateFlow()

     fun getPostList() = viewModelScope.launch {

        getPostsUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is utill.Result.Loading -> _postList.value = OtherBlogUiState.Loading
                    is utill.Result.Success -> if (result.data.isEmpty()) {
                        _postList.value = OtherBlogUiState.Empty

                    } else {
                        _postList.value = OtherBlogUiState.Success(result.data)
                    }
                    is utill.Result.Error -> {
                        _postList.value = OtherBlogUiState.Fail
                        result.exception.printStackTrace()
                    }
                }
            }
    }
}
