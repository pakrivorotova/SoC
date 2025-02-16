/*
 * hw_pipex_var.kt
 *
 *  Created on: 05.06.2019
 *      Author: Alexander Antonov <antonov.alex.alex@gmail.com>
 *     License: See LICENSE file for details
 */

package pipex

import hwast.*

open class hw_pipex_var(name : String, vartype : hw_type, defimm : hw_imm) : hw_var(name, vartype, defimm) {

    constructor(name : String, vartype : hw_type, defval : String)
        : this(name, vartype, hw_imm(defval))

    fun assign_succ(depow_fractions: hw_fracs, src: hw_param) {
        if (default_astc is Pipeline) (default_astc as Pipeline).assign_succ(depow_fractions, this, src)
        else ERROR("assign_succ cmd is out of place!")
    }

    fun assign_succ(depow_fractions: hw_fracs, src: Int) {
        if (default_astc is Pipeline) (default_astc as Pipeline).assign_succ(depow_fractions, this, src)
        else ERROR("assign_succ cmd is out of place!")
    }

    fun assign_succ(src: hw_param) {
        if (default_astc is Pipeline) (default_astc as Pipeline).assign_succ(this, src)
        else ERROR("assign_succ cmd is out of place!")
    }

    fun assign_succ(src: Int) {
        if (default_astc is Pipeline) (default_astc as Pipeline).assign_succ(this, src)
        else ERROR("assign_succ cmd is out of place!")
    }

    fun readprev() : hw_pipex_var {
        if (default_astc is Pipeline) return (default_astc as Pipeline).readprev(this)
        else ERROR("readprev cmd is out of place!")
        return this
    }
}

class hw_local(name : String, vartype : hw_type, defimm : hw_imm)
    : hw_pipex_var(name, vartype, defimm) {

    constructor(name : String, vartype : hw_type, defval : String)
        : this(name, vartype, hw_imm(defval))
}

class hw_local_sticky(name : String, vartype : hw_type, defimm : hw_imm)
    : hw_pipex_var(name, vartype, defimm) {

    constructor(name : String, vartype : hw_type, defval : String)
        : this(name, vartype, hw_imm(defval))
}

class hw_global(name : String, vartype : hw_type, defimm : hw_imm)
    : hw_pipex_var(name, vartype, defimm) {

    constructor(name : String, vartype : hw_type, defval : String)
        : this(name, vartype, hw_imm(defval))
}
