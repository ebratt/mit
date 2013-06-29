package ps1;

/** RatTerm is an immutable record type representing a term in a
    polynomial expression.  The term has the form coeff * x^expt.
    <p>

    A RatTerm t can be notated by the pair (C . E),
    where C is the string representation of t.coeff, and E is t.expt.
    <p>

    For a given RatTerm r, "coefficient of r" is synonymous with
    r.coeff, and likewise "exponent of r" is synonymous with r.expt.
    <p>

    (1 . 3), (3/4 . 17), (7/2 . -1), and (NaN . 74) are all valid
    RatTerms, corresponding to the polynomial terms "x^3", "3/4*x^17",
    "7/2*x^-1" and "NaN*x^74", respectively.
*/
public class RatTerm {
    /** coefficient of this term. */
    public final RatNum coeff;

    /** exponent of this term. */
    public final int expt;

    /** @requires c != null
        @effects
        constructs a new RatTerm t, with t.coeff = c and t.expt = e.
    */
    public RatTerm(RatNum c, int e) {
        coeff = c;
        expt = e;
    }

    /** Standard equality operation.
        @return true iff 'obj' is an instance of a RatTerm and 'this' = 'obj'
    */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RatTerm) {
            RatTerm rt = (RatTerm) obj;
            return this.expt == rt.expt && this.coeff.equals(rt.coeff);
        } else {
            return false;
        }
    }
    
	/**
	 * Return the additive inverse of this RatTerm.
	 * 
	 * @return a new Term equal to "0 - this"; if coeff.isNaN(), returns some r
	 *         such that r.coeff.isNaN()
	 */
	public RatTerm negate() {
		if (coeff.isNaN()) {
			return new RatTerm(coeff, expt);
		} else {
			return new RatTerm(coeff.negate(), expt);
		}
	}

    /** Returns an implementation-specific debugging string.
        @return implementation specific debugging string. */
    public String debugPrint() {
        return "Term<coeff:"+this.coeff.unparse()+" expt:"+this.expt+">";
    }

    @Override
    public String toString() { return debugPrint(); }
}
