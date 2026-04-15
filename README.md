# Bill Calculator for Phone Calls

System that calculates monthly phone call bills with differentiated costs by type (local, national, international).

## Running the Code

```bash
javac *.java
java main
```

## Clases

- **Call**: Abstract class for calls
- **LocalCall**: Local calls (time slots)
- **NationalInternationalCall**: National and international calls
- **Client**: Client data
- **Bill**: Generates invoice
- **Location**: City + country

## Costos

- Locals: $0.20/min (8-20hs L-V) o $0.10/min (resto)
- Nationals: Variable por localidad (CSV)
- Internationals: Variable por país (CSV)
- Monthly subscription: $15.0
