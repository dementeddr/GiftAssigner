# GiftAssigner
Gift-giving with the same group of people year after year gets tedious, and it can be hard to come up with new ideas. This is a way to mix it up, like an advanced way of drawing names from a hat. Perfect for Christmas with the family.

The idea is simple. You input a list of people and a list of gift categories (see the App.java file for examples). The tool assigns each person a person to give a gift of each category to. The assignments can be arranged such that each person gives a gift of each category (each to a different person), and also receives a gift of each catetory (each from a different person). The assignments are rotationally symmetric.

In a group with an even number of people, everyone will be mirrored with another person, meaning they may be giving and receiving an item of the same category. In groups with all spouses/partners, it may be desirable to avoid making spouses a mirrored pair so they can give each other gifts unrestricted by category. This is the default behavior and can be turned off by settign "mirrorSpouses" to false.


## Known Issues
* Spouse-mirroring logic currently assumes entire group is made of spouse pairs with no singles.
* Inputs are currently hard-coded (planning to make input a plaintext or xml file).
* If given more categories than the number of people -1, it will assign people multiple categories (configurable option?)