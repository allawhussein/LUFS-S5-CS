# Chapter 1 - Introduction

No need for notes for this chapter, check the pdf [here](lecture_slides_pdf/chapter_1.pdf).

## Forwarding and Routing

Swithcing depends on MAC address, Routing depends on IP address, and both are complementary.
How a packet is forwarded?

### routing table (which include destination IP addresses)
a router is connected to more than one network, where with each one there's a network interface (any simple computer have at least two network interfaces  WiFi and ethernet interface, additional interfaces are possible through USB network cards).  
Not every interface is the gateway of its network, sometimes it is just a host.

## Address Resolution Protocol
Used to resolve IP address, that is to identify the associated MAC address.  
LAN frames transmission is based solely on the MAC address, even when IP address is to be used, the MAC address is checked first.  
Through traversing each network the MAC address is changed in every network to match that of the next router.

### on same LAN
when the sending node have the destination IP but not the destination MAC, the ARP broadcasts a query packet containing the destination IP address, and the MAC address set to all FF-FF-FF-FF-FF-FF.  
The receiver will respond with its MAC address.
The sender will save the MAC address received into the ARP table.  
If the received network package have a matching MAC address, the package is processed, other wise it is sent to the IP layer for further processing (for possible routing).

### ARP packet content
- medium type
- protocol type (what address I'm trying to resolve).
- length of MAC address (if we're resolving a MAC).
- ...

### cases for using ARP
- sending a packet for a host on intranet.
- Sending packet for a host on an extranet (resolving the MAC address of the router).
- two routers switching packages between each other.
- the router connected to the destination host.

## Default Gateway
It is the exit way to outer networks, it is always the next hop for every packet going to the extranet.