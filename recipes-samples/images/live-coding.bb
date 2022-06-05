SUMMARY = "A reference yocto image for building devices such as those produced by Moddevices, community contributed"
HOMEPAGE = "https://github.com/MaxPayne86/meta-moddevices-contrib"
LICENSE = "MIT"

IMAGE_LINGUAS = "en-us"

inherit core-image

IMAGE_INSTALL += "\
    ninjam-client \
    ninjam-server \
    orca-c \
    supercollider \
    foxdot \
"
