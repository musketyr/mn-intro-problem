package mn.intro.problem

import com.agorapulse.dru.Dru
import com.agorapulse.dru.dynamodb.persistence.DynamoDB
import com.agorapulse.gru.Gru
import com.agorapulse.gru.agp.ApiGatewayProxy
import com.amazonaws.services.dynamodbv2.datamodeling.IDynamoDBMapper
import io.micronaut.context.ApplicationContext
import org.junit.Rule
import spock.lang.Specification

class MnIntroProblemFunctionSpec extends Specification {

    @Rule Dru dru = Dru.steal(this)

    @Rule Gru gru = Gru.equip(ApiGatewayProxy.steal(this) {
        map '/test/{hash}', GET to MicronautHandler
    })

    IDynamoDBMapper mapper = DynamoDB.createMapper(dru)

    void setup() {
        dru.add(new IntroProblemEntity(hashKey: 'hash1'))
        dru.add(new IntroProblemEntity2(hashKey: 'hash2'))

        MicronautHandler.reset()
        MicronautHandler.applicationContext.with { ApplicationContext context ->
            context.registerSingleton(IDynamoDBMapper, mapper)
        }
    }

    void "test me"() {
        expect:
            gru.test {
                get '/test/hash'
                expect {
                    json entities: [[hashKey: 'hash1'], [hashKey: 'hash2']]
                }
            }
    }

}
