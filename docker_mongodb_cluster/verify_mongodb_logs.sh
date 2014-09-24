#!/bin/sh

#execute these lines from command line

#grep mongodb logs
sudo docker logs rs1_srv1 | grep appDomain
sudo docker logs rs1_srv2 | grep appDomain
sudo docker logs rs1_srv3 | grep appDomain

#count number of lines:
sudo docker logs rs1_srv1 | grep appDomain | wc -l
sudo docker logs rs1_srv2 | grep appDomain | wc -l
sudo docker logs rs1_srv3 | grep appDomain | wc -l

