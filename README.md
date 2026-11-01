# Space Station — Visitor Pattern (Java)

Assignment #6, Software Design Patterns.
A Java implementation of the **Visitor** behavioral design pattern. The object structure is a space station made of modules. New operations (power balance, crew capacity, inspection report) are added **without modifying the module classes**.

## Build and run

Requires JDK 11 or newer.

```bash
javac -d out src/spacestation/*.java
java -cp out spacestation.Main
```

Expected output:

```
Power balance: 23.5 kW
Crew capacity: 5
Inspection report:
Living  'Harmony': check air filters, 4 beds
Lab     'Destiny': calibrate instruments, 6 experiments
Solar   'Array-A': clean 8 panels
Solar   'Array-B': clean 6 panels
```

## Pattern structure

| Pattern role | Class |
|---|---|
| Element interface | `Module` — declares `accept(ModuleVisitor)` |
| Concrete Elements | `LivingModule`, `LabModule`, `SolarModule` |
| Visitor interface | `ModuleVisitor` — one `visitX()` per concrete element |
| Concrete Visitors | `PowerBalanceVisitor`, `CrewCapacityVisitor`, `InspectionReportVisitor` |
| Object Structure | `SpaceStation` — holds a `List<Module>` and traverses it |
| Client | `Main` |

```
Module <<interface>>              ModuleVisitor <<interface>>
  + accept(v)                       + visitLivingModule(m)
     ▲                              + visitLabModule(m)
     │                              + visitSolarModule(m)
 LivingModule / LabModule /            ▲
 SolarModule                           │
                                PowerBalanceVisitor / CrewCapacityVisitor /
                                InspectionReportVisitor
SpaceStation ──► List<Module>
```

## How double dispatch works

1. The client calls `station.accept(visitor)`, which loops over the modules and calls `module.accept(visitor)`.
   The runtime type of the **module** selects which `accept()` runs (first dispatch).
2. Inside, each module calls `visitor.visitX(this)`. Here `this` has the exact module type,
   so the right overload is chosen, and the runtime type of the **visitor** selects which algorithm runs (second dispatch).

Result: the operation depends on both types, and no `if` / `instanceof` chain is needed.

## Clean Code principles applied

1. **Meaningful names** — `Module` vs `ModuleVisitor`; `accept` vs `visitX` make each role obvious.
2. **No `instanceof` / type checks** — double dispatch replaces them completely.
3. **Single Responsibility** — each visitor implements exactly one operation across all module types.
4. **Minimal encapsulation trade-off** — visitors need module data, so modules expose read-only getters only.
   Fields are `private final` and there are no setters, so visitors cannot change module state.
5. **Open/Closed & extensibility** — `InspectionReportVisitor` was added last; no module class and no `SpaceStation` code changed.
6. **Immutability** — all element fields are `final`.

## Trade-off

Adding a new module type requires adding a `visitX()` method to `ModuleVisitor` and updating every visitor.
Visitor fits best when the element hierarchy is stable and operations change often.

## Project layout

```
src/spacestation/
  Module.java                  ModuleVisitor.java
  LivingModule.java            LabModule.java            SolarModule.java
  PowerBalanceVisitor.java     CrewCapacityVisitor.java  InspectionReportVisitor.java
  SpaceStation.java            Main.java
```
