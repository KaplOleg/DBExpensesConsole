package practiceFive.Classes.IO

import practiceFive.Interfaces.IO.IInput

class InputToDesktop: IInput {
    override fun input(): String? {
        return readLine()
    }
}