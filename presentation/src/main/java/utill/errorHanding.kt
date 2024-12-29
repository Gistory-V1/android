package utill

import expection.*
fun Throwable.errorHandling(
    badRequestAction: () -> Unit = {},
    forbiddenAction: () -> Unit = {},
    notFoundAction: () -> Unit = {},
    notAcceptableAction: () -> Unit = {},
    timeOutAction: () -> Unit = {},
    conflictAction: () -> Unit = {},
    serverAction: () -> Unit = {},
    noInternetAction: () -> Unit = {},
    otherHttpAction: () -> Unit = {},
    unknownAction: () -> Unit = {},
) {
    when (this) {
        is BadRequestException -> badRequestAction()
        is ForBiddenException -> forbiddenAction()
        is NotFoundException -> notFoundAction()
        is NotAcceptableException -> notAcceptableAction()
        is TimeOutException -> timeOutAction()
        is ConflictException -> conflictAction()
        is ServerException -> serverAction()
        is NoInternetException -> noInternetAction()
        is OtherHttpException -> otherHttpAction()
        else -> unknownAction()
    }
}