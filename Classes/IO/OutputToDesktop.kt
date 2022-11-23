package practiceFive.Classes.IO

import practiceFive.Interfaces.IO.IOutput

class OutputToDesktop: IOutput {
    override fun print(message: String) {
        println(message)
    }
}