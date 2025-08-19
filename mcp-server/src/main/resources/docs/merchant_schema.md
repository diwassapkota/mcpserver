# Merchant Schema

This document provides an overview of the merchant-related tables in the database.

## Tables

### `MERCHANT_PAYMENT_ADVICE`

This table contains information about merchant payment advice.

```sql
CREATE TABLE `MERCHANT_PAYMENT_ADVICE` (
  `ID` bigint NOT NULL,
  `ACQUIRER` bigint DEFAULT NULL,
  `MERCHANT` bigint DEFAULT NULL,
  `TERMINAL_DETAILS` bigint DEFAULT NULL,
  `RETRIEVAL_REFERENCE_NUMBER` varchar(12) DEFAULT NULL,
  `TXN_AMOUNT` decimal(19,2) DEFAULT NULL,
  `INITIATOR` varchar(55) DEFAULT NULL,
  `FONEPAY_SESSION_ID` bigint DEFAULT NULL,
  `REQUEST_LOG` varchar(2555) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);
```

### `CUSTOMER_PROFILE`

This table contains information about customer profiles.

```sql
CREATE TABLE `CUSTOMER_PROFILE` (
  `ISSUER_NAME` varchar(255) DEFAULT NULL,
  `INITIATOR` varchar(20) DEFAULT NULL,
  `COUNT` bigint DEFAULT NULL,
  `AMOUNT` decimal(19,2) DEFAULT NULL,
  UNIQUE KEY `uk_issuer_initiator` (`ISSUER_NAME`,`INITIATOR`)
);
```

### `MERCHANT_PROFILE`

This table contains information about merchant profiles.

```sql
CREATE TABLE `MERCHANT_PROFILE` (
  `ACQUIRER` bigint DEFAULT NULL,
  `MERCHANT` bigint DEFAULT NULL,
  `TERMINAL_DETAILS` bigint DEFAULT NULL,
  `COUNT` bigint DEFAULT NULL,
  `AMOUNT` decimal(19,2) DEFAULT NULL,
  UNIQUE KEY `uk_acquirer_merchant_terminal` (`ACQUIRER`,`MERCHANT`,`TERMINAL_DETAILS`)
);
```

### `TRANSACTION_MINUTE_SUMMARY`

This table contains a summary of transactions per minute.

```sql
CREATE TABLE `TRANSACTION_MINUTE_SUMMARY` (
  `SUMMARY_DATE` date NOT NULL,
  `SUMMARY_MINUTE` time NOT NULL,
  `TXN_COUNT` bigint DEFAULT '0',
  `TXN_AMOUNT` decimal(19,2) DEFAULT '0.00',
  PRIMARY KEY (`SUMMARY_DATE`,`SUMMARY_MINUTE`)
);
```
