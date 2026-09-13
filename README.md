# Travel Package Builder

Assignment #1 — Builder creational design pattern (Software Design Patterns course).

## What is the product?

`TravelPackage` — a travel package made of a destination, hotel, trip length,
transport, and a set of optional extras (meals, insurance, a guide).
`destination`, `hotel`, `transport` and `days` are required; `meals`,
`insurance` and `guide` are optional add-ons. Travel packages genuinely need
step-by-step construction: a travel agency reuses the same "recipes" (budget,
comfort, luxury trip) over and over while still supporting fully custom
combinations. That is exactly the case the Builder pattern targets.

## Structure

| Component | File | Role |
|---|---|---|
| Product | `TravelPackage.java` | Immutable result object. Can only be constructed via the builder. |
| Builder | `TravelPackageBuilder.java` | Fluent, step-by-step assembly; validates state in `build()`. |
| Director | `TravelPackageDirector.java` | Encapsulates three reusable configurations: budget, comfort and luxury trips. |
| Client | `Main.java` | Exercises the director, a custom build, and the validation failure path. |

## Predefined configurations

- Budget Trip
- Comfort Trip
- Luxury Trip

Run it:

```bash
javac -d out src/*.java
java -cp out Main
```

## Clean Code principles applied

### 1. Meaningful, intention-revealing names

Boolean toggles read as sentences at the call site instead of generic flags.

```java
// Before
builder.setFlag1(true);
builder.setFlag2(true);

// After
builder.withMeals();
builder.withInsurance();
```

### 2. Small methods, each doing one thing

Every builder method sets exactly one field and returns `this` — no method
mixes assignment with validation or formatting.

```java
public TravelPackageBuilder hotel(String hotel) {
    this.hotel = hotel;
    return this;
}
```

### 3. Small, focused classes (single responsibility)

Each class has exactly one reason to change: `TravelPackage` only holds data,
`TravelPackageBuilder` only assembles and validates, `TravelPackageDirector`
only knows fixed recipes, `Main` only demonstrates usage. None of them do two
of these jobs at once.

### 4. Validated construction

`build()` never hands back a half-filled object. It calls a dedicated
`validate()` step first and fails loudly with a specific message.

```java
// Before (no validation — a caller could forget `days` entirely
// and silently get a package with days == 0)
public TravelPackage build() {
    return new TravelPackage(this);
}

// After
public TravelPackage build() {
    validate();
    return new TravelPackage(this);
}

private void validate() {
    if (days < MIN_DAYS || days > MAX_DAYS) {
        throw new IllegalStateException(
            "Trip length must be between " + MIN_DAYS + " and " + MAX_DAYS +
            " days, but was " + days + ".");
    }
    // ... other required-field checks
}
```

### 5. No magic numbers/strings

The valid trip-length range is named, not scattered as raw literals in the
validation logic.

```java
// Before
if (days < 1 || days > 60) { ... }

// After
private static final int MIN_DAYS = 1;
private static final int MAX_DAYS = 60;
...
if (days < MIN_DAYS || days > MAX_DAYS) { ... }
```
