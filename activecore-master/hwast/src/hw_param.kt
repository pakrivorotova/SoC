/*
 * hw_param.kt
 *
 *  Created on: 05.06.2019
 *      Author: Alexander Antonov <antonov.alex.alex@gmail.com>
 *     License: See LICENSE file for details
 */

package hwast

open class hw_param (var vartype : hw_type, var token_printable : String) {

    open fun GetString(): String {
        return token_printable
    }

    fun GetDimensions(): hw_dim_static {
        return vartype.dimensions
    }

    fun isDimSingle(): Boolean {
        return vartype.dimensions.isSingle()
    }

    fun GetWidth() : Int {
        return vartype.dimensions.last().GetWidth()
    }
}