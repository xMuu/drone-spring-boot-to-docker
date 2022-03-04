package dev.xmuu.droneci.demo.runner

import dev.xmuu.droneci.demo.util.TGUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

/**
 * @author xMuu
 * @date 2022/3/4
 * @description
 */

@Component
class DroneCiDemoRunner : ApplicationRunner{

    @Autowired
    private lateinit var tgUtil : TGUtil

    override fun run(args: ApplicationArguments?) {
        tgUtil.sendMessage("Updated!!! Drone CI Demo is up and running!")
    }

}