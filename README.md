# DNS Problem mit VPN

There was a problem in my Linux Mint config, that https://artifactory.atuprinet.ch could not get reached after VPN connection was established.

It was necessary to add following 2 Atupri DNS-Server manually to the Network settings:

```
192.168.156.18
192.168.156.19
```


## Enable Network Manager
It was necessary to set **managed=true** in [ifupdown] section of /etc/NetworkManager/NetworkManager.conf
```
sudo vi /etc/NetworkManager/NetworkManager.conf

[main]
plugins=ifupdown,keyfile

[ifupdown]
managed=true

[device]
wifi.scan-rand-mac-address=n
```

```bash
# in project root
$ nvm use
$ npm start
```

## Enter Atupri DNS Server in Network Manager

In Linux Mint System Tray clock on Network Icon. Then change the active connection settings.
In  The **IPV4 / DNS** Tab ensure, enter the 2 Atupri DNS-Server and ensure that the new Atupri DNS-Server are before the existing one

So the new DNS-Server sequence is 

```
192.168.156.18
192.168.156.19
192.168.178.1
```


## Veriy if DNS resolution works correctly
```aidl
$ nslookup artifactory.atuprinet.ch 
Server:		127.0.0.53
Address:	127.0.0.53#53

Non-authoritative answer:
artifactory.atuprinet.ch	canonical name = srvart1-prod.atuprinet.ch.
Name:	srvart1-prod.atuprinet.ch
Address: 10.253.27.108

```
