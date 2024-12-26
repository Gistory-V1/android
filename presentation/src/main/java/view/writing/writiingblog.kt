package view.writing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.navigation.NavigationBar
import com.kim.presentation.R
import view.myblog.popup.DeleteSearchHistoryDialogs
import view.post.viewmodel.writeviewmodel
@Composable
internal fun BookAddBookRoute(
    modifier: Modifier = Modifier,
    witeviewmodel: writeviewmodel = hiltViewModel(),
    navigateToBack: () -> Unit,
) {
    val titleTextState by witeviewmodel.titleTextState.collectAsStateWithLifecycle()
    val writeTextState by witeviewmodel.writeTextState.collectAsStateWithLifecycle()

    val titleTextStateIsEmpty by witeviewmodel.titleTextStateIsEmpty.collectAsStateWithLifecycle()
    val writeTextStateIsEmpty by witeviewmodel.writeTextStateIsEmpty.collectAsStateWithLifecycle()

    val (checkBookDialogState, toggleCheckBookDialogState) = remember { mutableStateOf(false) }

    WritingBlogScreenWithoutBorders(
        modifier = modifier,
        titleTextState = titleTextState,
        writeTextState = writeTextState,
        checkBookDialogState = checkBookDialogState,
        updateTitleTextState = witeviewmodel::onTitleChanged,
        updateWriteTextState = witeviewmodel::onWriteChanged,
        toggleCheckBookDialogState = { toggleCheckBookDialogState(!checkBookDialogState) },
        checkButtonOnClick = {
            if (witeviewmodel.validateAndSetErrorStates()) {
                witeviewmodel.checkButtonOnClick(
                    titleTextState,
                    writeTextState,
                )
                witeviewmodel.resetTextState()
                navigateToBack()
            }
        },
        navigateToBack = navigateToBack,
    )
}
@Composable
fun WritingBlogScreenWithoutBorders(
    modifier: Modifier = Modifier,
    focusManager: FocusManager = LocalFocusManager.current,
    titleTextState: String,
    writeTextState: String,
    checkBookDialogState: Boolean,
    updateTitleTextState: (String) -> Unit,
    updateWriteTextState: (String) -> Unit,
    checkButtonOnClick: () -> Unit,
    toggleCheckBookDialogState: () -> Unit,
    navigateToBack: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFFFFFF))
            .padding(16.dp) // 전체 여백
    ) {
        // 상단 툴바
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_28),
                contentDescription = "뒤로가기 아이콘",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { navigateToBack() },
                contentScale = ContentScale.Fit
            )
            Row(
                modifier = Modifier
                    .width(90.dp)
                    .height(40.dp)
                    .border(
                        width = 0.5.dp,
                        color = Color(0xFF868686),
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .clickable { checkButtonOnClick() }
                    .padding(end = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "완료",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF000000)
                    )
                )
            }
        }
        if (checkBookDialogState) {
            Dialog(onDismissRequest = toggleCheckBookDialogState) {
                DeleteSearchHistoryDialogs(
                    onDismiss = toggleCheckBookDialogState,
                    onConfirm = checkButtonOnClick
                )
            }
        }

        // 제목 입력 필드
        BasicTextField(

            value = titleTextState,
            onValueChange = updateTitleTextState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textStyle = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            decorationBox = { innerTextField ->
                Column {
                    Text(
                        text = "제목",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                    )
                    innerTextField()
                }
            }
        )

        // 내용 입력 필드
        BasicTextField(
            value = writeTextState,
            onValueChange = updateWriteTextState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            ),
            decorationBox = { innerTextField ->
                Column {
                    Text(
                        text = "내용을 입력해주세요",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    )
                    innerTextField()
                }
            }
        )
    }

    NavigationBar(
        onClick = { /* 적절한 동작 */ }
    )
}




@Preview
@Composable
fun WritingBlogScreenPreview() {
    WritingBlogScreenWithoutBorders(
        titleTextState = "",
        writeTextState = "",
        checkBookDialogState = false,
        updateTitleTextState = {},
        updateWriteTextState = {},
        checkButtonOnClick = {},
        toggleCheckBookDialogState = {},
        navigateToBack = {}
    )
}
