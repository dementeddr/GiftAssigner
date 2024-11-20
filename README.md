# GiftAssigner
Gift-giving with the same group of people year after year gets tedious, and it can be hard to come up with new ideas. This is a way to mix it up, like an advanced way of drawing names from a hat. Perfect for Christmas with the family.

The idea is simple. You input a list of people and a list of gift categories (see the App.java file for examples). The tool assigns each person someone to give a gift of each category to. The assignments can be arranged such that each person gives a gift of each category (each to a different person), and also receives a gift of each catetory (each from a different person). The assignments are rotationally symmetric.

In a group with an even number of people, everyone will be mirrored with another person, meaning they may be exchanging gifts of the same category. In groups with all spouses/partners, it may be desirable to make partners the mirrored pairs and intentionally avoid assigning a category to those pairs. That way partners can give each other gifts unrestricted by category. This is the default behavior and can be turned off by setting "mirrorPartners" to false. With an odd number of people, "mirrorPartners" has no functionality.


## Known Issues
* Partner-mirroring logic currently assumes entire group is made of partner pairs with no singles.
* If given more categories than the number of people -1, it will assign some people multiple categories (could make a configurable option?)


## Planned features
* Make tool read input from a plaintext or json file (input is currently hard-coded).
* Allow users to specify a large set of categories and have the tool select a random subset of those.
* Make option to enforce a Hamiltonian Cycle in assignments (may be desirable for certain large-group gift exchange games).
* Give users the ability to select a specific category (or lack of category) to mirrored pairs
* Allow the tool to use the mirrorPartner logic on groups that are not all pairs of partners, by randomly pairingotherwise unpaired people.
* Add a cheater-mode, allowing you to add specific assignments you want in the results. If you're the one running the exchange, you can run it how you like!
* Add seeded randomization and output the seed, to make it easier to recover lost arrangements
