CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    -- Update the balance by adding 1% interest for all savings accounts
    UPDATE savings_accounts
    SET balance = balance + (balance * 0.01);
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Handle any exceptions
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
        ROLLBACK;
END ProcessMonthlyInterest;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN NUMBER,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    -- Update the salary by adding a bonus percentage for employees in the specified department
    UPDATE employees
    SET salary = salary + (salary * p_bonus_percentage / 100)
    WHERE department_id = p_department_id;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Handle any exceptions
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonus: ' || SQLERRM);
        ROLLBACK;
END UpdateEmployeeBonus;

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    insufficient_balance EXCEPTION;
    current_balance NUMBER;
BEGIN
    -- Check if the source account has sufficient balance
    SELECT balance INTO current_balance
    FROM accounts
    WHERE account_id = p_from_account_id;
    
    IF current_balance < p_amount THEN
        RAISE insufficient_balance;
    END IF;

    -- Proceed with the transfer if sufficient balance
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account_id;

    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account_id;

    COMMIT;
EXCEPTION
    WHEN insufficient_balance THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance in source account.');
        ROLLBACK;
    WHEN OTHERS THEN
        -- Handle any other exceptions
        DBMS_OUTPUT.PUT_LINE('Error during fund transfer: ' || SQLERRM);
        ROLLBACK;
END TransferFunds;
