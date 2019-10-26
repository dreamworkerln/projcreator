#!/bin/bash
CURRUSER=$(whoami | awk '{print $1}')

rsync -avz out/ /usr/local/bin/
#chmod ug+x /usr/local/bin/projcreator
chown    ${CURRUSER}: /usr/local/bin/projcreator
chown -R ${CURRUSER}: /usr/local/bin/projcreator_data/