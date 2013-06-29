package ps1;

/** Cons is a simple cons cell record type. */
class Cons {
    RatPoly head;
    Cons tail;
    Cons(RatPoly h, Cons t) { head = h; tail = t; }
}

/** <b>RatPolyStack</B> is a mutable finite sequence of RatPoly objects.
    <p>
    Each RatPolyStack can be described by [p1, p2, ... ], where [] is
    an empty stack, [p1] is a one element stack containing the Poly
    'p1', and so on.  RatPolyStacks can also be described
    constructively, with the append operation, ':'. such that [p1]:S
    is the result of putting p1 at the front of the RatPolyStack S.
    <p>
    A finite sequence has an associated size, corresponding to the
    number of elements in the sequence.  Thus the size of [] is 0, the
    size of [p1] is 1, the size of [p1, p1] is 2, and so on.
    <p>
    Note that RatPolyStack is similar to <i>lists</i> like {@link
    java.util.ArrayList} with respect to its abstract state (a finite
    sequence), but is quite different in terms of intended usage.  A
    stack typically only needs to support operations around its top
    efficiently, while a vector is expected to be able to retrieve
    objects at any index in amortized constant time.  Thus it is
    acceptable for a stack to require O(n) time to retrieve an element
    at some arbitrary depth, but pushing and popping elements should
    be O(1) time.

*/
public class RatPolyStack {

    private Cons polys; // head of list
    private int size;   // redundantly-stored list length

    // Definitions:
    //   For a Cons c, let Seq(c) be [] if c == null,
    //                               [c.head]:Seq(c.tail) otherwise
    //                     Count(c) be 0 if c == null,
    //                                 1 + Count(c.tail) otherwise
    //
    // (These are helper functions that will make it easier for us
    // to write the remainder of the specifications.  They are
    // seperated out because the nature of this representation lends
    // itself to analysis by recursive functions.)

    // Abstraction Function:
    //   RatPolyStack s models Seq(s.polys)
    // (This explains how we can understand what a Stack is from its
    // 'polys' field.  (Though in truth, the real understanding comes
    // from grokking the Seq helper function).)

    // RepInvariant:
    //   s.size == Count(s.polys)
    // (This defines how the 'size' field relates to the 'polys'
    // field.  Notice that s.polys != null is *not* a given Invariant;
    // this class, unlike the RatPoly class, allows for one of its
    // fields to reference null, and thus your method implementations
    // should not assume that the 'polys' field will be non-null on
    // entry to the method, unless some other aspect of the method
    // will enforce this condition.)

    /** @effects Constructs a new RatPolyStack, [].
     */
    public RatPolyStack() {
        size = 0;
        polys = null;
    }

    /** Pushes a RatPoly onto the top of this.
        @requires p != null
        @modifies this
        @effects this_post = [p]:this
    */
    public void push(RatPoly p) {
        //TODO: Fill in this method, then remove the RuntimeException
        throw new RuntimeException("RatPolyStack->push() unimplemented!\n");
    }

    /** Removes and returns the top RatPoly.
        @requires this.size() > 0
        @modifies this
        @effects If this = [p]:S
        then this_post = S && returns p
    */
    public RatPoly pop() {
        //TODO: Fill in this method, then remove the RuntimeException
        throw new RuntimeException("RatPolyStack->pop() unimplemented!\n");
    }

    /** Duplicates the top RatPoly on this.
        @requires this.size() > 0
        @modifies this
        @effects If this = [p]:S
        then this_post = [p, p]:S
    */
    public void dup() {
        //TODO: Fill in this method, then remove the RuntimeException
        throw new RuntimeException("RatPolyStack->dup() unimplemented!\n");
    }

    /** Swaps the top two elements of this.
        @requires this.size() >= 2
        @modifies this
        @effects If this = [p1, p2]:S
        then this_post = [p2, p1]:S
    */
    public void swap() {
        //TODO: Fill in this method, then remove the RuntimeException
        throw new RuntimeException("RatPolyStack->swap() unimplemented!\n");
    }

    /** Clears the stack.
        @modifies this
        @effects this_post = []
    */
    public void clear() {
        //TODO: Fill in this method, then remove the RuntimeException
        throw new RuntimeException("RatPolyStack->clear() unimplemented!\n");
    }

    /** Returns the RatPoly that is 'index' elements from the top of
        the stack.
        @requires index >= 0 && index < this.size()
        @effects If this = S:[p]:T where S.size() = index, then
        returns p.
    */
    public RatPoly get(int index) {
        //TODO: Fill in this method, then remove the RuntimeException
        throw new RuntimeException("RatPolyStack->get() unimplemented!\n");
    }

    /** Adds the top two elements of this, placing the result on top
        of the stack.
        @requires this.size() >= 2
        @modifies this
        @effects  If this = [p1, p2]:S
        then this_post = [p3]:S
        where p3 = p1 + p2
    */
    public void add() {
        //TODO: Fill in this method, then remove the RuntimeException
        throw new RuntimeException("RatPolyStack->add() unimplemented!\n");
    }

    /** Subtracts the top poly from the next from top poly, placing
        the result on top of the stack.
        @requires this.size() >= 2
        @modifies this
        @effects  If this = [p1, p2]:S
        then this_post = [p3]:S
        where p3 = p2 - p1
    */
    public void sub() {
        //TODO: Fill in this method, then remove the RuntimeException
        throw new RuntimeException("RatPolyStack->sub() unimplemented!\n");
    }

    /** Multiplies top two elements of this, placing the result on
        top of the stack.
        @requires this.size() >= 2
        @modifies this
        @effects  If this = [p1, p2]:S
        then this_post = [p3]:S
        where p3 = p1 * p2
    */
    public void mul() {
        //TODO: Fill in this method, then remove the RuntimeException
        throw new RuntimeException("RatPolyStack->mul() unimplemented!\n");
    }

    /** Divides the next from top poly by the top poly, placing the
        result on top of the stack.
        @requires this.size() >= 2
        @modifies this
        @effects  If this = [p1, p2]:S
        then this_post = [p3]:S
        where p3 = p2 / p1
    */
    public void div() {
        //TODO: Fill in this method, then remove the RuntimeException
        throw new RuntimeException("RatPolyStack->div() unimplemented!\n");
    }

    /** Integrates the top element of this, placing the result on top
        of the stack.
        @requires this.size() >= 1
        @modifies this
        @effects  If this = [p1]:S
        then this_post = [p2]:S
        where p2 = indefinite integral of p1 with integration constant 0
    */
    public void integrate() {
        //TODO: Fill in this method, then remove the RuntimeException
        throw new RuntimeException("RatPolyStack->integrate() unimplemented!\n");
    }

    /** Differentiates the top element of this, placing the result on top
        of the stack.
        @requires this.size() >= 1
        @modifies this
        @effects  If this = [p1]:S
        then this_post = [p2]:S
        where p2 = derivative of p1
    */
    public void differentiate() {
        //TODO: Fill in this method, then remove the RuntimeException
        throw new RuntimeException("RatPolyStack->differentiate() unimplemented!\n");
    }

    /** Returns the number of RayPolys in this RatPolyStack.
        @return the size of this sequence.
     */
    public int size() {
        //TODO: Fill in this method, then remove the RuntimeException
        throw new RuntimeException("RatPolyStack->size() unimplemented!\n");
    }

    /** Checks to see if the representation invariant is being violated and if so, throws RuntimeException
        @throws RuntimeException if representation invariant is violated
    */
    private void checkRep() throws RuntimeException {

        if(polys == null) {
            if(size != 0)
                throw new RuntimeException("size field should be equal to zero when polys is null sine stack is empty");
        } else {

            int countResult = 0;
            RatPoly headPoly = polys.head;
            Cons nextCons = polys;

            if(headPoly != null) { 
                for (int i = 1;; i++) {
                    if(nextCons != null) {
                        countResult = i;
                        nextCons = nextCons.tail;
                    } else
                        break;                
                }
            }
            if(countResult != size)
                throw new RuntimeException("size field is not equal to Count(s.polys). Size constant is "+size+" Cons cells have length "+countResult);   
        }
    }
}
