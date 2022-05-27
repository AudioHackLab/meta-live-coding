SUMMARY = "NINJAM is open source (GPL) software to allow people to make real music together via the Internet"
DESCRIPTION = "NINJAM is open source (GPL) software to allow people to make real music together via the Internet. Every participant can hear every other participant. Each user can also tweak their personal mix to his or her liking. NINJAM is cross-platform, with clients available for Mac OS X, Linux, and Windows. REAPER (our digital audio workstation software for Windows and OS X) also includes NINJAM support (ReaNINJAM plug-in)."
HOMEPAGE = "https://www.cockos.com/ninjam/"
SECTION = "audio/network"
LICENSE = "GPL-2.0"

INSANE_SKIP_${PN} += "ldflags"
INSANE_SKIP_${PN} += "already-stripped"

SRC_URI = "git://github.com/AudioHackLab/ninjam.git;protocol=http \
	file://gcc.patch \
	file://ninjam.cfg"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git/ninjam/server"
LIC_FILES_CHKSUM = "file://${S}/license.txt;md5=393a5ca445f6965873eca0259a17f833"

inherit pkgconfig

do_compile() {
        oe_runmake clean
        oe_runmake
}

do_install () {
	install -d ${D}/usr/bin
	install -m 0755 ${S}/ninjamsrv ${D}/usr/bin
	install -d ${D}/etc/
	install -m 0644 ${WORKDIR}/ninjam.cfg ${D}/etc/
	install -d ${D}/usr/share/ninjam/
	install -m 0644 ${S}/cclicense.txt ${D}/usr/share/ninjam/cclicense.txt
}
FILES_${PN} = "/usr/bin /etc /usr/share/ninjam"
