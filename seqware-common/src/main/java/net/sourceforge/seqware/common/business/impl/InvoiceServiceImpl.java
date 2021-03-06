package net.sourceforge.seqware.common.business.impl;

import java.util.Date;
import java.util.List;
import net.sourceforge.seqware.common.business.InvoiceService;
import net.sourceforge.seqware.common.dao.InvoiceDAO;
import net.sourceforge.seqware.common.model.Invoice;
import net.sourceforge.seqware.common.model.InvoiceState;
import net.sourceforge.seqware.common.model.Registration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * InvoiceServiceImpl class.
 * </p>
 * 
 * @author boconnor
 * @version $Id: $Id
 */
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceDAO invoiceDAO = null;
    private static final Log LOG = LogFactory.getLog(InvoiceServiceImpl.class);

    /**
     * <p>
     * Constructor for InvoiceServiceImpl.
     * </p>
     */
    public InvoiceServiceImpl() {
        super();
    }

    /**
     * {@inheritDoc}
     * 
     * Sets a private member variable with an instance of an implementation of InvoiceDAO. This method is called by the Spring framework at
     * run time.
     * 
     * @see InvoiceDAO
     */
    @Override
    public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
        this.invoiceDAO = invoiceDAO;
    }

    /** {@inheritDoc} */
    @Override
    public Integer insert(Invoice invoice) {
        invoice.setCreateTimestamp(new Date());
        return invoiceDAO.insert(invoice);
    }

    /** {@inheritDoc} */
    @Override
    public void update(Invoice invoice) {
        invoiceDAO.update(invoice);
    }

    /** {@inheritDoc} */
    @Override
    public void delete(Invoice invoice) {
        invoiceDAO.delete(invoice);
    }

    /**
     * <p>
     * list.
     * </p>
     * 
     * @return a {@link java.util.List} object.
     */
    @Override
    public List<Invoice> list() {
        return invoiceDAO.list();
    }

    /** {@inheritDoc} */
    @Override
    public List<Invoice> list(Registration registration) {
        return invoiceDAO.list(registration);
    }

    /** {@inheritDoc} */
    @Override
    public List<Invoice> list(Registration registration, InvoiceState state) {
        return invoiceDAO.list(registration, state);
    }

    /** {@inheritDoc} */
    @Override
    public Invoice findByID(Integer iID) {
        Invoice invoice = null;
        if (iID != null) {
            try {
                invoice = invoiceDAO.findByID(iID);
            } catch (Exception exception) {
                LOG.error("Cannot find Invoice by wfID " + iID);
                LOG.error(exception.getMessage());
            }
        }
        return invoice;
    }

    /** {@inheritDoc} */
    @Override
    public Invoice findBySWAccession(Integer swAccession) {
        Invoice invoice = null;
        if (swAccession != null) {
            try {
                invoice = invoiceDAO.findBySWAccession(swAccession);
            } catch (Exception exception) {
                LOG.error("Cannot find Invoice by swAccession " + swAccession);
                LOG.error(exception.getMessage());
            }
        }
        return invoice;
    }

    /** {@inheritDoc} */
    @Override
    public Invoice updateDetached(Invoice invoice) {
        return invoiceDAO.updateDetached(invoice);
    }

    /** {@inheritDoc} */
    @Override
    public Integer insert(Registration registration, Invoice invoice) {
        invoice.setCreateTimestamp(new Date());
        return invoiceDAO.insert(registration, invoice);
    }

    /** {@inheritDoc} */
    @Override
    public Invoice updateDetached(Registration registration, Invoice invoice) {
        return invoiceDAO.updateDetached(registration, invoice);
    }

    /** {@inheritDoc} */
    @Override
    public void update(Registration registration, Invoice invoice) {
        invoiceDAO.update(registration, invoice);
    }
}
