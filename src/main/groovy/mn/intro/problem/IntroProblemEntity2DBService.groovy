package mn.intro.problem

import com.agorapulse.micronaut.aws.dynamodb.annotation.Service

@Service(IntroProblemEntity2)
interface IntroProblemEntity2DBService {

    IntroProblemEntity2 load(String hash)

}
