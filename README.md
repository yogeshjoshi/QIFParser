# QIFParser

[![GPL-3.0](https://img.shields.io/badge/license-GPL--3.0-blue.svg)](LICENSE)

Java library for reading the QIF (Quicken Interchange Format Files) files.

## File Format 
A QIF file typically has the following structure:
<pre>
!Type:[type identifier string]
[single character line code]Literal String Data
...
^
[single character line code]Literal String Data
...
^
</pre>

QIF File format Example-
<pre>
!Type:Bank
D03/03/10
T-379.00
PCITY OF SPRINGFIELD
^
D03/04/10
T-20.28
PYOUR LOCAL SUPERMARKET
^
D03/03/10
T-421.35
PSPRINGFIELD WATER UTILITY
^
...etc.
</pre>

## Full File Format Discription 
see full file format description at https://en.wikipedia.org/wiki/Quicken_Interchange_Format
