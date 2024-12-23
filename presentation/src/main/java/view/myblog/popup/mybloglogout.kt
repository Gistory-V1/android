package view.myblog.popup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DeleteSearchHistoryDialogs(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        backgroundColor = Color.White,
        shape = RoundedCornerShape(12.dp),
        buttons = {
            Column(
                modifier = Modifier
                    .width(345.dp)
                    .background(Color.White)
            ) {
                // Title Section
                Text(
                    text = "로그아웃\n로그아웃 삭제하시겠습니까?",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF111111),
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, bottom = 24.dp)
                )

                // Divider
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color(0xFFD9D9D9))
                )

                // Button Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(53.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Cancel Button
                    TextButton(
                        onClick = { onDismiss() },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "취소",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF111111)
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }

                    // Divider
                    Spacer(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .background(Color(0xFFD9D9D9))
                    )

                    // Confirm Button
                    TextButton(
                        onClick = { onConfirm() },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "로그아웃",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFFFF5A5A)
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    )
}
@Composable
fun DeleteSearchHistoryDialogss(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        backgroundColor = Color.White,
        shape = RoundedCornerShape(12.dp),
        buttons = {
            Column(
                modifier = Modifier
                    .width(345.dp)
                    .background(Color.White)
            ) {
                // Title Section
                Text(
                    text = "회원 탈퇴\n정말로 회원을 탈퇴하시겠습니까?",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF111111),
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, bottom = 24.dp)
                )

                // Divider
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color(0xFFD9D9D9))
                )

                // Button Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(53.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Cancel Button
                    TextButton(
                        onClick = { onDismiss() },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "취소",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF111111)
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }

                    // Divider
                    Spacer(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .background(Color(0xFFD9D9D9))
                    )

                    // Confirm Button
                    TextButton(
                        onClick = { onConfirm() },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "회원탈퇴",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFFFF5A5A)
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun DeleteSearchHistoryDialogPreviesw() {
    DeleteSearchHistoryDialogs(
        onConfirm = {},
        onDismiss = {}
    )
}



