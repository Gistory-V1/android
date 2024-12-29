package usecase.book

import kotlinx.coroutines.flow.Flow
import model.auth.request.witecreaterequestModel
import reopoistory.WriteRepository
import javax.inject.Inject

class createPostUseCase @Inject constructor(
    private val writeRepository: WriteRepository,
){
    suspend operator fun invoke(body: witecreaterequestModel) = runCatching {
        writeRepository.createPost( body=body)
    }

}