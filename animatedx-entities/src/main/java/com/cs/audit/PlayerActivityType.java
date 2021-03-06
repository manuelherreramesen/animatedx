package com.cs.audit;

/**
 * @author Hadi Movaghar
 */
public enum PlayerActivityType {
    LOGIN,
    FAILED_LOGIN,
    LOGOUT,
    START_GAME,
    END_GAME,
    SELF_BLOCK,

    REQ_GET_PLAYER_INFO,
    REQ_UPDATE_PLAYER,
    REQ_DELETE_PLAYER,
    REQ_CREATE_PLAYER,
    REQ_CREATE_PLAYER_DURING_CAMPAIGN,
    REQ_GET_PLAYER_ADDRESS,
    REQ_UPDATE_PLAYER_ADDRESS,
    REQ_GET_PLAYER_WALLET,
    REQ_GET_PLAYER_ITEMS,
    REQ_CREATE_RESET_PASSWORD,
    REQ_RESET_PASSWORD,
    REQ_USE_ITEM,
    REQ_VERIFY_PLAYER_EMAIL,
    REQ_GET_PLAYER_LIMITS,
    REQ_UPDATE_PLAYER_LIMITS,
    REQ_SELF_EXCLUSION,
    REQ_GET_CREDITS_CONVERSION_RATE,
    REQ_CONVERT_CREDITS_TO_MONEY,
    REQ_CONVERT_CREDITS_TO_BONUS,
    REQ_GET_PAYMENT_TRANSACTION,
    REQ_GET_CAPTURED_PAYMENT_TRANSACTION,
    REQ_GET_PAYMENT_TRANSACTIONS_LIST,
    REQ_GET_WITHDRAW_DETAILS,
    REQ_SEND_WITHDRAW_REQUEST,
    REQ_SEND_DEPOSIT_REQUEST,
    REQ_PLAY_GAME,
    REQ_GET_GAME_TRANSACTIONS,
    REQ_STORE_BANK_ACCOUNT_FOR_WITHDRAW,
    REQ_GET_PLAYER_BONUSES,
    REQ_GET_PLAYER_PROMOTIONS,
    REQ_GET_AVAILABLE_DEPOSIT_BONUSES,
    REQ_GET_CURRENT_BONUSES,
    REQ_ACTIVATE_LINK_BONUS,
    REQ_CANCEL_BONUS,
    REQ_ACCEPT_TERMS_AND_CONDITIONS,

    CREATE_PLAYER_DURING_CAMPAIGN,

    CONVERT_CREDITS_TO_MONEY,
    CONVERT_CREDITS_TO_BONUS,

    FRAUD_DEPOSITS_PER_TIME,
    FRAUD_DEPOSIT_METHOD_PER_TIME,
    FRAUD_DEPOSITS_OVER_AMOUNT_PER_TIME,

    CANCELLED_BONUS,
    GRANTED_BONUS,
    USED_MONEY_BONUS,
    USED_BONUS_AMOUNT,
    USED_DEPOSIT_BONUS,
    USED_FREE_ROUND_BONUS,
    FREE_ROUNDS_COMPLETION_BONUS,

    ENROLLED_IN_PROMOTION,

    DEPOSIT_MONEY_REQUEST,
    DEPOSIT_MONEY,

    WITHDRAW_MONEY_REQUEST,
    WITHDRAW_MONEY_REQUEST_FAILED,
    BONUS_RESERVED_ON_WITHDRAW,

    WITHDRAW_MONEY,
    WITHDRAW_MONEY_CONFIRMED,
    WITHDRAW_MONEY_DECLINED,

    STORE_BANK_ACCOUNT_INFO,

    GIVE_CASHBACK,

    ACCEPTED_TERRMS_AND_CONDITIONS,

    WALLET_ERROR
}
