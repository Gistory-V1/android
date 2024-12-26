package usecase.book

import kotlinx.coroutines.flow.Flow
import model.auth.request.witecreaterequestModel
import reopoistory.WriteRepository
import javax.inject.Inject

class createPostUseCase @Inject constructor(
    private val writeRepository: WriteRepository,
){
    operator suspend fun invoke(sessionId: String,body: witecreaterequestModel) = runCatching {
        writeRepository.createPost(sessionId =sessionId, body=body)
    }

}