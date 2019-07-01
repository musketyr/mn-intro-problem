package mn.intro.problem

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller('/test')
class TestController {

    private final IntroProblemEntityDBService firstService
    private final IntroProblemEntity2DBService secondService

    TestController(IntroProblemEntityDBService firstService, IntroProblemEntity2DBService secondService) {
        this.firstService = firstService
        this.secondService = secondService
    }

    @Get('/{hash}')
    List show(String hash) {
        return [firstService.load(hash), secondService.load(hash)]
    }

}
