# meta-celestial

Applies recipes for creating a dual-boot RFS, with the rest of flash being saved to NVM

## Classes

### sdcard_image-rpi-dualboot

Partitions an RPI SD card per the following schema.  The remaining space on the SD card is allocated to NVM via the [nvmfs recipe](#nvmfs).  The partition table format is outlined in the [bbclass file](./classes/sdcard_image-rpi-dualboot.bbclass).

To generate this image, add the following to your build's `local.conf`.

```bash
# Use the rpi dualboot image
IMAGE_CLASSES += " sdcard_image-rpi-dualboot "
IMAGE_FSTYPES += " rpi-dualboot-sdimg "
```

## Recipes

### recipes-core


#### nvmfs

Fills the remainder of the main flash memory device with an NVM partition at `/dev/mmcblk0p4`.

#### packagegroups

Adds the `packagegroup-celestial` recipe.  In general, you'll put this in your local.conf file as `CORE_IMAGE_EXTRA_INSTALL += " packagegroup-celestial "`

