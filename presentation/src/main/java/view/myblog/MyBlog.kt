package view.myblog


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.navigation.NavigationBar
import com.kim.presentation.R
import model.auth.response.prfilereponseModel
import usecase.profile.ProfileUseCase
import view.main.component.MainItem
import view.myblog.UiState.ProfileUiState
import view.myblog.viewModel.otherProfileViewModel
import view.otherblog.componet.otherBlogItem


@Composable
internal fun SettingRoute(
    onBackClick: () -> Unit,
    viewModel: otherProfileViewModel = hiltViewModel()
){
    val profileUiState by viewModel.profileState.collectAsStateWithLifecycle()

    MyBlogs(

        getOtherProfile = viewModel::getOtherProfile,
        onBackClick = onBackClick,
        profileUiState = profileUiState,
        modifier = Modifier,
    )

}
@Composable
fun MyBlogs(
    getOtherProfile: (userId: String) -> Unit,
    profileUiState: ProfileUiState,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    when (profileUiState) {
        is ProfileUiState.Empty -> {
            Text(text = "오류")
        }

        is ProfileUiState.Loading -> {
            Text(text = "로딩")
        }

        is ProfileUiState.Fail -> {
            Text(text = "오류")
        }

        is ProfileUiState.Success -> {
            name(
                data = profileUiState.data,
                modifier = modifier,
            )
            }

        }


    }

@Preview
@Composable
fun MyblogPreview() {
    MyBlogs(

        getOtherProfile = {},
        profileUiState = ProfileUiState.Loading,
        onBackClick = {},
        modifier = Modifier,
    )
}
