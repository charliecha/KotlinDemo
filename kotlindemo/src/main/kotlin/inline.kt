import java.util.concurrent.locks.Lock
import javax.swing.tree.TreeNode

inline fun <T> lock(l : Lock, foo : () -> T) : T {
    l.lock()
    try {
        return foo()
    } finally {
        l.unlock()
    }
}

class Test {
    val test : Test
        inline get() = Test()
}

 inline fun <reified T> TreeNode.findParentOfType() : T? {
    var p = parent
    while (p != null && p !is T) {
        p = p.parent
    }
    return p as T?
}