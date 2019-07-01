package mn.intro.problem

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller('/test')
class TestController {

    private final IntroProblemEntityDBService dbService

    TestController(IntroProblemEntityDBService dbService) {
        this.dbService = dbService
    }

    @Get('/{hash}')
    IntroProblemEntity show(String hash) {
        return dbService.load(hash)
    }

}
