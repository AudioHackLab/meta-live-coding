DESCRIPTION = "SuperCollider is a programming language for real time audio synthesis and algorithmic composition."
HOMEPAGE = "http://supercollider.github.io/"
LICENSE = "GPL-3.0"

SRC_URI = "gitsm://github.com/supercollider/supercollider;protocol=git;branch=3.11 \
"
SRCREV = "0412d3b37390356faed6e6d469309dfd8c8a4cc7"

S = "${WORKDIR}/git/"

LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=d32239bcb673463ab874e80d47fae504"

EXTRA_OECMAKE = "\
	-DSC_IDE=OFF -DNO_X11=ON -DSC_QT=OFF -DSC_ED=OFF -DSC_EL=OFF -DSC_VIM=ON \
	-DCMAKE_BUILD_TYPE=Release \
	-DNATIVE=OFF \
	-DSSE=OFF \
	-DSSE2=OFF \
	-DCMAKE_SKIP_RPATH=ON \
	-DDSO_VISIBILITY=ON \
	-DSC_EL_BYTECOMPILE=OFF \
	-DSYSTEM_BOOST=ON \
	-DENABLE_TESTSUITE=OFF \
	-DLIBSCSYNTH=OFF \
	-DSYSTEM_YAMLCPP=OFF \
	-DSUPERNOVA=OFF \
"
inherit cmake

DEPENDS = "fftw jack libsndfile1 alsa-lib boost udev"
RDEPENDS_${PN} = "libsndfile1 boost"
TARGET_CC_ARCH += "-pthread" 

FILES_${PN} += " \
  ${libdir}/SuperCollider/plugins/*.so \
  ${datadir}/SuperCollider/SCClassLibrary/* \
  ${datadir}/SuperCollider/sounds/* \
  ${datadir}/SuperCollider/Extensions/* \
  ${datadir}/SuperCollider/HID_Support/* \
"

FILES_${PN}-dbg += " \
  ${libdir}/SuperCollider/plugins/.debug/*.so \
"

FILES_${PN}-dev += " \
  ${datadir}/scvim/* \
  ${datadir}/SuperCollider/Extensions/scvim/* \
  ${datadir}/vim/* \
  ${datadir}/mime/packages/supercollider.xml \
"

FILES_${PN}-doc += " \
  ${datadir}/SuperCollider/AUTHORS \
  ${datadir}/SuperCollider/README.md \
  ${datadir}/SuperCollider/COPYING \
  ${datadir}/SuperCollider/CHANGELOG.md \
  ${datadir}/SuperCollider/README_LINUX.md \
  ${datadir}/SuperCollider/HelpSource/* \
  ${datadir}/SuperCollider/examples/* \
"
