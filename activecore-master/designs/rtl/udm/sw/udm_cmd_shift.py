# -*- coding:utf-8 -*-
from __future__ import division

import udm
from udm import *

udm = udm('COM12', 921600)
print("")

CSR_LED_ADDR    = 0x00000000
CSR_SW_ADDR     = 0x00000004
TESTMEM_ADDR    = 0x80000000

CSR_CMD_REG     = 0x000000FF
CSR_CMD_SHIFT   = 0x000000F0
CSR_CMD_RESULT  = 0x000000F5





udm.wr32(CSR_LED_ADDR, 0xaa55)
print("SW read: ", hex(udm.rd32(CSR_SW_ADDR)))
udm.memtest32(TESTMEM_ADDR, 1024)


#our code
reg = 0xff
shift = 0x5
udm.wr32(CSR_CMD_SHIFT, shift)
udm.wr32(CSR_CMD_REG, reg)
print("Result: ", hex(udm.rd32(CSR_CMD_RESULT)))
udm.disconnect()
