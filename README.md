# Soar Parser

This project is a standalone parser for the Soar programming language. The parser is implemented using JavaCC and returns a full AST structure for Soar source files. My goals for this project are:

* Create a standalone, reusable Soar parser in Java
* Test comprehensively
* Learn more about JavaCC and maybe JJTree

This project forked the parser from VisualSoar as its starting point, but
will not remain backwards compatible. Most of the tests will be taken from
[Soar::Production](https://metacpan.org/module/Soar::Production::Parser).

# Limitations
The parser does not support `gp` productions at this time. It does,
however, allow for [JSoar](http://soartech.github.io/jsoar/)-style TCL expansions in square brackets.

## References

* [SoarSuite project home](https://code.google.com/p/soar/)
* [JSoar](http://soartech.github.io/jsoar/)
* [Agent Development Tools](https://code.google.com/p/soar/wiki/DLCategory_AgentDev)
* [Soar::Production](https://metacpan.org/module/Soar::Production::Parser)
* [JavaCC](https://javacc.java.net/)
