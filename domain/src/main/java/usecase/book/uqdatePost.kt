package usecase.book

import kotlinx.coroutines.flow.Flow
import model.auth.request.witecreaterequestModel
import reopoistory.WriteRepository
import javax.inject.Inject

class uqdatePost @Inject constructor(
    private val writeRepository: WriteRepository
){
    suspend operator fun invoke(sessionId: String, postId: Long,body: witecreaterequestModel): Flow<Unit> =
        writeRepository.updatePost(sessionId = sessionId,postId = postId,body = body)

}