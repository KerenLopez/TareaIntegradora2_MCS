package model;

/**
* Enum <br>
* <b>name</b>: Category <br>
*<code> NEWBIE </code> is a rank that the user gets when is newly registered, and keeps it until he/she shares three songs in the pool.
*<code> LITTLE_CONTRIBUTOR </code> is a rank that the user gets from three songs shared, and keeps it until he/she shares ten songs in the pool.
*<code> MILD_CONTRIBUTOR </code> is a rank that the user gets from ten songs shared, and keeps it until he/she shares thirty songs in the pool.
*<code> STAR_CONTRIBUTOR </code> is a rank that the user gets from he/she shares thirty songs in the pool.
*/

public enum Category{

	NEWBIE, LITTLE_CONTRIBUTOR, MILD_CONTRIBUTOR, STAR_CONTRIBUTOR;

}