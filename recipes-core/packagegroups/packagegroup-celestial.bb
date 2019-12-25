SUMMARY = "Packages installed on the Celstial project BSP"
PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = "\
     openssh \
     docker \
     git \
     vim \
     nvmfs \
     curl \
"