DESCRIPTION = "PortMidi is a platform independent library for MIDI input/output."
HOMEPAGE = "http://portmedia.sourceforge.net/"
LICENSE = "GPL-3.0"

SRC_URI = "git://github.com/schollz/portmidi-1;protocol=git \
	file://remove_test.patch \
"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM = "file://${S}/license.txt;md5=a0c1c261bc48165d48388e3a121a31e9"

EXTRA_OECMAKE = "\
	-DCMAKE_INSTALL_PREFIX=/usr \
        -DCMAKE_ARCHIVE_OUTPUT_DIRECTORY=Release \
        -DCMAKE_LIBRARY_OUTPUT_DIRECTORY=Release \
        -DCMAKE_RUNTIME_OUTPUT_DIRECTORY=Release \
"

inherit cmake

DEPENDS = "alsa-lib"

do_install() {
    install -d -m 755 ${D}${libdir}/
    install -p -m 644 ${WORKDIR}/build/pm_dylib/Release/libportmidi.so ${D}${libdir}/libportmidi.so.0.0.0
    install -p -m 644 ${WORKDIR}/build/pm_common/Release/libportmidi_s.a ${D}${libdir}/libportmidi.a
    install -d ${D}${includedir}
    install -m 0755 ${S}/pm_common/portmidi.h ${D}${includedir}
#    install -m 0755 ${S}/porttime/porttime.h ${D}${includedir}
}

FILES_${PN}-dev = " \
    ${includedir}/*.h \
"
