# Replace use the network interfaces script with the one in .../files/celestial/interfaces
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://celestial/interfaces "

do_install_append() {
	install -m 0644 ${WORKDIR}/celestial/interfaces ${D}${sysconfdir}/network/interfaces
}

CONFFILES_${PN} += "${sysconfdir}/network/interfaces"