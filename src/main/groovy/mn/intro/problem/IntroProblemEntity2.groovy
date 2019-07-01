package mn.intro.problem

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import groovy.transform.Canonical
import groovy.transform.CompileStatic

@Canonical
@CompileStatic
@DynamoDBTable(tableName = "IntroProblemEntity2")
class IntroProblemEntity2 {

    @DynamoDBHashKey
    String hashKey

}
