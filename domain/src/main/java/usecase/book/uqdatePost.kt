package usecase.book

import kotlinx.coroutines.flow.Flow
import model.auth.request.witecreaterequestModel
import model.auth.request.writeputModel
import reopoistory.WriteRepository
import javax.inject.Inject

class uqdatePost @Inject constructor(
    private val writeRepository: WriteRepository
){
    suspend operator fun invoke(body: writeputModel): Flow<Unit> =
        writeRepository.updatePost(body = body)

}