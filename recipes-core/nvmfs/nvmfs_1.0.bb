inherit systemd
SUMMARY = "Creates and mounts the NVM partition"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "file://init-nvmfs"
SRC_URI += "file://nvmfs.service"

S = "${WORKDIR}"

RDEPENDS_${PN} += " bash "

SYSTEMD_SERVICE_${PN} = "nvmfs.service"

do_install() {
    install -d "${D}/sbin"
    install -m 0755 "${WORKDIR}/init-nvmfs" "${D}/sbin"

    install -d "${D}/${sysconfdir}/systemd/system"
    install -m 0644 "${WORKDIR}/nvmfs.service" "${D}/${sysconfdir}/systemd/system"

    install -d "${D}/nvm"
}


#Pack the path
FILES_${PN} += "/sbin"
FILES_${PN} += "/nvm"
FILES_${PN} += "${sysconfdir}/systemd/system"

REQUIRED_DISTRO_FEATURES= "systemd"