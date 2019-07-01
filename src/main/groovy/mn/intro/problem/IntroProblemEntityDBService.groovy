package mn.intro.problem

import com.agorapulse.micronaut.aws.dynamodb.annotation.Service

@Service(IntroProblemEntity)
interface IntroProblemEntityDBService {

    IntroProblemEntity load(String hash)

}
