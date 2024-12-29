package usecase.book

import kotlinx.coroutines.flow.Flow
import model.auth.response.PostresponseModel
import reopoistory.WriteRepository
import javax.inject.Inject

class getPostUseCase @Inject constructor(
    private val writeRepository: WriteRepository,
){
    suspend operator fun invoke(): Flow<List<PostresponseModel>> =
        writeRepository.getPosts()

}