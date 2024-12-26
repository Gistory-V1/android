package usecase.book

import kotlinx.coroutines.flow.Flow
import model.auth.response.PostresponseModel
import reopoistory.WriteRepository
import javax.inject.Inject

class getPost @Inject constructor(
    private val writeRepository: WriteRepository,
){
    suspend operator fun invoke(sessionId: String, postId: Int): Flow<List<PostresponseModel>> =
        writeRepository.getPosts(sessionId = sessionId,postId = postId)

}