package rlaope.jvmtest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URLClassLoader

class LeakyClassLoader : URLClassLoader(arrayOf(), null)

@RestController
class BuggyController {

    val leakyLoaders = mutableListOf<ClassLoader>()

    // ClassLoader 누수 발생용
    @GetMapping("/api/class-leak")
    fun classLeak(): String {
        repeat(1000) {
            val loader = LeakyClassLoader()
            loader.loadClass("java.lang.String")
            leakyLoaders.add(loader)
        }
        return "class loader leaked"
    }

    // StackOverflowError 발생용
    @GetMapping("/api/overflow")
    fun overflow(): String {
        fun recurse(): String = recurse() // 무한 재귀
        return recurse()
    }

    // OOM 발생용
    @GetMapping("/api/oom")
    fun oom(): String {
        val list = mutableListOf<ByteArray>()
        while (true) {
            list.add(ByteArray(10_000_000)) // 10MB씩 계속 추가
        }
        return "won't reach"
    }
}