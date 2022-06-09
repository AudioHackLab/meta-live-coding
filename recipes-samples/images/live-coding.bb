SUMMARY = "A reference yocto image for live coding"
HOMEPAGE = "https://audiohacklab.org/"
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
