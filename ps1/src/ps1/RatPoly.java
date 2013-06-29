package ps1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <b>RatPoly</b> represents an immutable single-variate polynomial expression.
 * RatPolys have RatNum coefficients and integer exponents.
 * <p>
 * 
 * Examples of RatPolys include "0", "x-10", and "x^3-2*x^2+5/3*x+3", and "NaN".
 */
public class RatPoly {

	/** holds all the RatTerms in this RatPoly */
	private List<RatTerm> terms;

	/** convenient zero constant */
	private static final RatNum ZERO = new RatNum(0);

	/** convenient one constant */
	private static final RatNum ONE = new RatNum(1);

	/** convenient NaN constant */
	private static final RatNum NAN = new RatNum(1, 0);

	/** convenient NaN RatPoly */
	private static final RatPoly NANPOLY;

	static {
		NANPOLY = new RatPoly();
		NANPOLY.terms.add(new RatTerm(new RatNum(1, 0), 0));
	}
	
	/** convenient ZERO RatPoly */
	private static final RatPoly ZEROPOLY;
	
	static {
		ZEROPOLY = new RatPoly();
		ZEROPOLY.terms.add(new RatTerm(ZERO, 1));
	}
	
	/** convenient ONE RatPoly */
	private static final RatPoly ONEPOLY;
	
	static {
		ONEPOLY = new RatPoly();
		ONEPOLY.terms.add(new RatTerm(ONE, 1));
	}

	static RatPoly valueOf(){
		RatPoly nanPoly = new RatPoly();
		nanPoly.terms.add(new RatTerm(new RatNum(1, 0), 0));
		return nanPoly;
	}

	// Definitions:
	// For a RatPoly p, let C(p,i) be "p.terms.get(i).coeff" and
	// E(p,i) be "p.terms.get(i).expt"
	// length(p) be "p.terms.size()"
	// (These are helper functions that will make it easier for us
	// to write the remainder of the specifications. They are not
	// executable code; they just represent complex expressions in a
	// concise manner, so that we can stress the important parts of
	// other expressions in the spec rather than get bogged down in
	// the details of how we extract the coefficient for the 2nd term
	// or the exponent for the 5th term. So when you see C(p,i),
	// think "coefficient for the ith term in p".)

	// Abstraction Function:
	// A RatPoly p is the Sum, from i=0 to length(p), of C(p,i)*x^E(p,i)
	// (This explains what the state of the fields in a RatPoly
	// represents: it is the sum of a series of terms, forming an
	// expression like "C_0 + C_1*x^1 + C_2*x^2 + ...". If there are no
	// terms, then the RatPoly represents the zero polynomial.)

	// Representation Invariant for every RatPoly p:
	// terms != null &&
	// forall i such that (0 <= i < length(p), C(p,i) != 0 &&
	// forall i such that (0 <= i < length(p), E(p,i) >= 0 &&
	// forall i such that (0 <= i < length(p) - 1), E(p,i) > E(p, i+1)
	// (This tells us four important facts about every RatPoly:
	// * the terms field always points to some usable object,
	// * no term in a RatPoly has a zero coefficient,
	// * no term in a RatPoly has a negative exponent, and
	// * the terms in a RatPoly are sorted in descending exponent order.)

	/**
	 * @effects Constructs a new Poly, "0".
	 */
	public RatPoly() {
		if (terms == null) {
			terms = new ArrayList<RatTerm>();	
		}
	}

	/**
	 * @requires e >= 0
	 * @effects Constructs a new Poly equal to "c * x^e". If c is zero,
	 *          constructs a "0" polynomial.
	 */
	public RatPoly(int c, int e) {
		if (e < 0) throw new IllegalArgumentException("exponent must be >= 0");
		new RatPoly();
		terms.add(new RatTerm(new RatNum(c), e)); 	
	}

	/**
	 * @requires 'rt' satisfies clauses given in rep. invariant
	 * @effects Constructs a new Poly using 'rt' as part of the representation.
	 *          The method does not make a copy of 'rt'.
	 */
	private RatPoly(List<RatTerm> rt) {
		checkRep();
		new RatPoly();
		terms.addAll(rt); 
	}

	/**
	 * Returns the degree of this RatPoly.
	 * 
	 * @requires !this.isNaN()
	 * @return the largest exponent with a non-zero coefficient, or 0 if this is
	 *         "0".
	 */
	public int degree() {
		checkRep();

		/*
		 * The try-finally clause is an easy way to call checkRep() every time
		 * you exit a function. The code enclosed by finally { ... } is executed
		 * whenever the try block is exited.
		 */

		int retVal = 0;
		try {
			if (this.isNaN()) throw new IllegalArgumentException("this cannot be NaN");
			if (!(this.isZero())) {
				Iterator<RatTerm> it = terms.listIterator();
				RatTerm last = null;
				while (it.hasNext()) {
					RatTerm next = it.next();
					RatNum coeff = next.coeff;
					if (coeff.approx() != 0.0) {
						if (next.expt > last.expt) retVal = next.expt;
					}
					last = next;
				}
			}
		} finally {
			checkRep();
		}
		return retVal;
	}

	/**
	 * Get the coefficient of a term.
	 * 
	 * @requires !this.isNaN()
	 * @return the coefficient associated with term of degree 'deg'. If there is
	 *         no term of degree 'deg' in this poly, then returns zero.
	 */
	public RatNum coeff(int deg) {
		// TODO: Fill in this method, then remove the RuntimeException
		throw new RuntimeException("RatPoly->coeff() unimplemented!");
	}

	/**
	 * Return true if this RatPoly is not-a-number.
	 * 
	 * @return true if and only if this has some coefficient = "NaN".
	 */
	public boolean isNaN() {
		return this.equals(NANPOLY);
	}

	/**
	 * Return true if this RatPoly is zero
	 * 
	 * @return true if and only if this RatPoly is "0".
	 */
	public boolean isZero() {
		return this.equals(ZEROPOLY);
	}

	/**
	 * Returns a string representation of this RatPoly.
	 * 
	 * @return A String representation of the expression represented by this,
	 *         with the terms sorted in order of degree from highest to lowest.
	 *         <p>
	 *         There is no whitespace in the returned string.
	 *         <p>
	 *         If the polynomial is itself zero, the returned string will just
	 *         be "0".
	 *         <p>
	 *         If this.isNaN(), then the returned string will be just "NaN"
	 *         <p>
	 *         The string for a non-zero, non-NaN poly is in the form
	 *         "(-)T(+|-)T(+|-)...",where for each term, T takes the form
	 *         "C*x^E" or "C*x", UNLESS: (1) the exponent E is zero, in which
	 *         case T takes the form "C", or (2) the coefficient C is one, in
	 *         which case T takes the form "x^E" or "x"
	 *         <p>
	 *         Note that this format allows only the first term to be output as
	 *         a negative expression.
	 *         <p>
	 *         Valid example outputs include "x^17-3/2*x^2+1", "-x+1", "-1/2",
	 *         and "0".
	 *         <p>
	 */
	public String unparse() {
		if (this.isZero()) return "0";
		if (this.isNaN()) return "NaN";
		StringBuffer sb = new StringBuffer();
		Iterator<RatTerm> it = terms.listIterator();
		while (it.hasNext()) {
			RatTerm rt = it.next();
			RatNum coeff = rt.coeff;
			if (coeff.isPositive() && sb.length() != 0) sb.append("+");
			if (coeff.isNegative()) sb.append("-");
			if (coeff.compareTo(ONE) != 0 && coeff.negate().compareTo(ONE) !=0) {
				sb.append(coeff.approx());
				sb.append("*");
			} else {
				sb.append("x");
			}
			int expt = rt.expt;
			if (expt < 0) throw new IllegalArgumentException("exponent cannot be negative");
			if (expt > 1) {
				sb.append("^");
				sb.append(expt);
			}
		}
		return sb.toString();
	}

	/**
	 * Scales coefficients within 'list' by 'scalar' (helper procedure).
	 * 
	 * @requires list, scalar != null
	 * @modifies list
	 * @effects Forall i s.t. 0 <= i < list.size(), if (C . E) = list.get(i)
	 *          then list_post.get(i) = (C*scalar . E)
	 * @see ps1.RatTerm regarding (C . E) notation
	 */
	private static void scaleCoeff(List<RatTerm> list, RatNum scalar) {
		// TODO: Fill in this method, then remove the RuntimeException
		throw new RuntimeException("RatPoly->scaleCoeff() unimplemented!");
	}

	/**
	 * Increments exponents within 'list' by 'degree' (helper procedure).
	 * 
	 * @requires list != null
	 * @modifies list
	 * @effects Forall i s.t. 0 <= i < list.size(), if (C . E) = list.get(i)
	 *          then list_post.get(i) = (C . E+degree)
	 * @see ps1.RatTerm regarding (C . E) notation
	 */
	private static void incremExpt(List<RatTerm> list, int degree) {
		// TODO: Fill in this method, then remove the RuntimeException
		throw new RuntimeException("RatPoly->incremExpt() unimplemented!");
	}

	/**
	 * Merges a term into a sequence of terms, preserving the sorted nature of
	 * the sequence (helper procedure).
	 * 
	 * Definitions: Let a "Sorted List<RatTerm>" be a List<RatTerm> L such that
	 * [1] L is sorted in descending exponent order && [2] there are no two
	 * RatTerms with the same exponent in L && [3] there is no RatTerm in L with
	 * a coefficient equal to zero
	 * 
	 * For a Sorted List<RatTerm> L and integer e, let cofind(L, e) be either
	 * the coefficient for a RatTerm rt in L whose exponent is e, or zero if
	 * there does not exist any such RatTerm in L. (This is like the coeff
	 * function of RatPoly.)
	 * 
	 * @requires list != null && sorted(list)
	 * @modifies list
	 * @effects sorted(list_post) && cofind(list_post,newTerm.expt) =
	 *          cofind(list,newTerm.expt) + newTerm.coeff
	 */
	private static void sortedAdd(List<RatTerm> list, RatTerm newTerm) {
		// TODO: Fill in this method, then remove the RuntimeException
		throw new RuntimeException("RatPoly->sortedAdd() unimplemented!");
	}

	/**
	 * Return the additive inverse of this RatPoly.
	 * 
	 * @return a new Poly equal to "0 - this"; if this.isNaN(), returns some r
	 *         such that r.isNaN()
	 */
	public RatPoly negate() {
		// TODO: Fill in this method, then remove the RuntimeException
		throw new RuntimeException("RatPoly->negate() unimplemented!");
	}

	/**
	 * Addition operation.
	 * 
	 * @requires p != null
	 * @return a new RatPoly, r, such that r = "this + p"; if this.isNaN() or
	 *         p.isNaN(), returns some r such that r.isNaN()
	 */
	public RatPoly add(RatPoly p) {
		if (p == null) throw new IllegalArgumentException("p may not be null");
		if (this.isNaN() || p.isNaN()) return NANPOLY;
		Iterator<RatTerm> itThis = this.terms.listIterator();
		Iterator<RatTerm> itP = p.terms.listIterator();
		
		return ZEROPOLY;
	}

	/**
	 * Subtraction operation.
	 * 
	 * @requires p != null
	 * @return a new RatPoly, r, such that r = "this - p"; if this.isNaN() or
	 *         p.isNaN(), returns some r such that r.isNaN()
	 */
	public RatPoly sub(RatPoly p) {
		// TODO: Fill in this method, then remove the RuntimeException
		throw new RuntimeException("RatPoly->sub() unimplemented!");
	}

	/**
	 * Multiplication operation.
	 * 
	 * @requires p != null
	 * @return a new RatPoly, r, such that r = "this * p"; if this.isNaN() or
	 *         p.isNaN(), returns some r such that r.isNaN()
	 */
	public RatPoly mul(RatPoly p) {
		// TODO: Fill in this method, then remove the RuntimeException
		throw new RuntimeException("RatPoly->mul() unimplemented!");
	}

	/**
	 * Division operation (truncating).
	 * 
	 * @requires p != null
	 * @return a new RatPoly, q, such that q = "this / p"; if p = 0 or
	 *         this.isNaN() or p.isNaN(), returns some q such that q.isNaN()
	 *         <p>
	 * 
	 *         Division of polynomials is defined as follows: Given two
	 *         polynomials u and v, with v != "0", we can divide u by v to
	 *         obtain a quotient polynomial q and a remainder polynomial r
	 *         satisfying the condition u = "q * v + r", where the degree of r
	 *         is strictly less than the degree of v, the degree of q is no
	 *         greater than the degree of u, and r and q have no negative
	 *         exponents.
	 *         <p>
	 * 
	 *         For the purposes of this class, the operation "u / v" returns q
	 *         as defined above.
	 *         <p>
	 * 
	 *         Thus, "x^3-2*x+3" / "3*x^2" = "1/3*x" (with the corresponding r =
	 *         "-2*x+3"), and "x^2+2*x+15 / 2*x^3" = "0" (with the corresponding
	 *         r = "x^2+2*x+15").
	 *         <p>
	 * 
	 *         Note that this truncating behavior is similar to the behavior of
	 *         integer division on computers.
	 */
	public RatPoly div(RatPoly p) {
		checkRep();

		// Check for NaN
		if (p.isNaN() || isNaN()) {
			// TODO: Return a NaN RatPoly, then remove the RuntimeException
			throw new RuntimeException(
					"RatPoly->div(): NaN RatPoly not defined!");
		}

		// Check for zero RatPoly in this and in p
		// TODO: Return a Zero RatPoly if this is a Zero RatPoly, then
		// remove the RuntimeException
		if (p.isZero() || isZero()) {
			throw new RuntimeException(
					"RatPoly->div(): Zero RatPoly not checked!");
		}

		// The rest of the method has been provided to you by the staff:
		// Start with a new polynomial
		List<RatTerm> remainder = new ArrayList<RatTerm>(terms);
		List<RatTerm> divisor;
		List<RatTerm> ans = new ArrayList<RatTerm>();
		while (!remainder.isEmpty() && remainder.get(0).expt >= p.degree()) {
			RatNum factor = remainder.get(0).coeff.div(p.coeff(p.degree()));
			sortedAdd(ans,
					new RatTerm(factor, remainder.get(0).expt - p.degree()));
			divisor = new ArrayList<RatTerm>(p.terms);
			scaleCoeff(divisor, factor);
			incremExpt(divisor, remainder.get(0).expt - p.degree());
			for (RatTerm term : divisor) {
				sortedAdd(remainder, term.negate());
			}
		}

		RatPoly result = new RatPoly(ans);

		result.checkRep();
		return result;
	}

	/**
	 * Return the derivative of this RatPoly.
	 * 
	 * @return a new RatPoly that, q, such that q = dy/dx, where this == y. In
	 *         other words, q is the derivative of this. If this.isNaN(), then
	 *         return some q such that q.isNaN()
	 * 
	 *         <p>
	 *         The derivative of a polynomial is the sum of the derivative of
	 *         each term.
	 * 
	 *         <p>
	 *         Given a term, a*x^b, the derivative of the term is: (a*b)*x^(b-1)
	 *         for b > 0 and 0 for b == 0
	 */
	public RatPoly differentiate() {
		// TODO: Fill in this method, then remove the RuntimeException
		throw new RuntimeException("RatPoly->differentiate() unimplemented!");
	}

	/**
	 * Returns the antiderivative of this RatPoly.
	 * 
	 * @requires integrationConstant != null
	 * @return a new RatPoly that, q, such that dq/dx = this and the constant of
	 *         integration is "integrationConstant" In other words, q is the
	 *         antiderivative of this. If this.isNaN() or
	 *         integrationConstant.isNaN(), then return some q such that
	 *         q.isNaN()
	 * 
	 *         <p>
	 *         The antiderivative of a polynomial is the sum of the
	 *         antiderivative of each term plus some constant.
	 * 
	 *         <p>
	 *         Given a term, a*x^b, (where b >= 0) the antiderivative of the
	 *         term is: a/(b+1)*x^(b+1)
	 */
	public RatPoly antiDifferentiate(RatNum integrationConstant) {
		// TODO: Fill in this method, then remove the RuntimeException
		throw new RuntimeException(
				"RatPoly->antiDifferentiate() unimplemented!");
	}

	/**
	 * Returns the integral of this RatPoly, integrated from lowerBound to
	 * upperBound.
	 * 
	 * @return a double that is the definite integral of this with bounds of
	 *         integration between lowerBound and upperBound.
	 * 
	 *         <p>
	 *         The Fundamental Theorem of Calculus states that the definite
	 *         integral of f(x) with bounds a to b is F(b) - F(a) where dF/dx =
	 *         f(x) NOTE: Remember that the lowerBound can be higher than the
	 *         upperBound
	 */
	public double integrate(double lowerBound, double upperBound) {
		// TODO: Fill in this method, then remove the RuntimeException
		throw new RuntimeException("RatPoly->integrate() unimplemented!");
	}

	/**
	 * Returns the value of this RatPoly, evaluated at d.
	 * 
	 * @return the value of this polynomial when evaluated at 'd'. For example,
	 *         "x+2" evaluated at 3 is 5, and "x^2-x" evaluated at 3 is 6. if
	 *         (this.isNaN() == true), return Double.NaN
	 */
	public double eval(double d) {
		// TODO: Fill in this method, then remove the RuntimeException
		throw new RuntimeException("RatPoly->eval() unimplemented!");
	}

	/**
	 * Builds a new RatPoly, given a descriptive String.
	 * 
	 * @requires 'polyStr' is an instance of a string with no spaces that
	 *           expresses a poly in the form defined in the unparse() method.
	 *           <p>
	 * 
	 *           Valid inputs include "0", "x-10", and "x^3-2*x^2+5/3*x+3", and
	 *           "NaN".
	 * @return a RatPoly p such that p.unparse() = polyStr
	 */
	public static RatPoly parse(String polyStr) {
		
		if (polyStr == "0") return ZEROPOLY;
		if (polyStr == "x") return ONEPOLY;

		RatPoly result = new RatPoly();

		// First we decompose the polyStr into its component terms;
		// third arg orders "+" and "-" to be returned as tokens.
		StringTokenizer termStrings = new StringTokenizer(polyStr, "+-", true);

		boolean nextTermIsNegative = false;
		while (termStrings.hasMoreTokens()) {
			String termToken = termStrings.nextToken();

			if (termToken.equals("-")) {
				nextTermIsNegative = true;
			} else if (termToken.equals("+")) {
				nextTermIsNegative = false;
			} else {
				// Not "+" or "-"; must be a term

				// Term is: "R" or "R*x" or "R*x^N" or "x^N" or "x",
				// where R is a rational num and N is a natural num.

				// Decompose the term into its component parts.
				// third arg orders '*' and '^' to act purely as delimiters.
				StringTokenizer numberStrings = new StringTokenizer(termToken,
						"*^", false);

				RatNum coeff;
				int expt;

				String c1 = numberStrings.nextToken();
				if (c1.equals("x")) {
					// ==> "x" or "x^N"
					coeff = new RatNum(1);

					if (numberStrings.hasMoreTokens()) {
						// ==> "x^N"
						String N = numberStrings.nextToken();
						expt = Integer.parseInt(N);

					} else {
						// ==> "x"
						expt = 1;
					}
				} else {
					// ==> "R" or "R*x" or "R*x^N"
					String R = c1;
					coeff = RatNum.parse(R);

					if (numberStrings.hasMoreTokens()) {
						// ==> "R*x" or "R*x^N"
						String x = numberStrings.nextToken();

						if (numberStrings.hasMoreTokens()) {
							// ==> "R*x^N"
							String N = numberStrings.nextToken();
							expt = Integer.parseInt(N);
						} else {
							// ==> "R*x"
							expt = 1;
						}

					} else {
						// ==> "R"
						expt = 0;
					}
				}

				// at this point, coeff and expt are initialized.
				// Need to fix coeff if it was preceeded by a '-'
				if (nextTermIsNegative) {
					coeff = coeff.negate();
				}

				// accumulate terms of polynomial in 'result'
				if (!coeff.equals(new RatNum(0))) {
					RatPoly termPoly = new RatPoly();
					termPoly.terms.add(new RatTerm(coeff, expt));
					result = result.add(termPoly);
				}
			}
		}
		result.checkRep();
		return result;
	}

	/**
	 * Checks to see if the representation invariant is being violated and if
	 * so, throws RuntimeException
	 * 
	 * @throws RuntimeException
	 *             if representation invariant is violated
	 */
	private void checkRep() throws RuntimeException {
		if (terms == null) {
			assert (false) : "CheckRep assert";
			throw new RuntimeException("terms == null!");
		}
		for (int i = 0; i < terms.size(); i++) {
			if ((terms.get(i).coeff.compareTo(new RatNum(0))) == 0) {
				throw new RuntimeException("zero coefficient!");
			}
			if (terms.get(i).expt < 0) {
				throw new RuntimeException("negative exponent!");
			}
			if (i < terms.size() - 1) {
				if (terms.get(i + 1).expt >= terms.get(i).expt) {
					throw new RuntimeException("terms out of order!");
				}
			}
		}
	}
}
